package SbbShowRailReports;

import Service.SbbApiService.RailTrafficInformationRecord;
import Service.SbbApiService.SbbApiService;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

public class SbbShowRailReportsApp extends Application {

    private final ObservableList<RailTrafficInformationRecord> rtiRecords = FXCollections.observableArrayList();
    private final SbbApiService sbbApiService = new SbbApiService();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TableView<RailTrafficInformationRecord> tableView = createTableView();
        VBox.setVgrow(tableView, Priority.ALWAYS);

        VBox root = new VBox(10, getHeading(), tableView);
        root.setPadding(new Insets(10));

        primaryStage.setScene(new Scene(root, 1024, 512));
        primaryStage.setTitle("SBB Fahrplaninformationen");
        primaryStage.show();

        refreshSchedule();
        startPeriodicRefresh(30);
    }

    private void startPeriodicRefresh(int intervalSeconds) {
        Timeline autoRefreshTimeline = new Timeline(
                new KeyFrame(Duration.seconds(intervalSeconds), event -> {
                    // Für Notifications keine Zeit mehr gehabt
                    refreshSchedule();
                })
        );
        autoRefreshTimeline.setCycleCount(Animation.INDEFINITE);
        autoRefreshTimeline.play();
    }

    private void refreshSchedule() {
        CompletableFuture.supplyAsync(sbbApiService::searchRailTrafficInformation)
            .thenAccept(rti -> {
                System.out.println(LocalDate.now() + " " + LocalTime.now() + " Loading API Data");
                if (rti != null && rti.records != null) {
                    // setAll replaces all existing items with the new API response
                    Platform.runLater(() -> rtiRecords.setAll(rti.records));
                }
            });
    }

    private Label getHeading() {
        Label label = new Label("Fahrplaninformationen");

        label.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        label.setPadding(new Insets(10));

        return label;
    }

    private TableView<RailTrafficInformationRecord> createTableView() {
        TableView<RailTrafficInformationRecord> table = new TableView<>(rtiRecords);

        table.setPlaceholder(new Label("Informationen werden geladen ..."));

        TableColumn<RailTrafficInformationRecord, String> publishedCol = new TableColumn<>("Datum / Zeit");
        publishedCol.setCellValueFactory(data ->
                new ReadOnlyStringWrapper(data.getValue().fields.published)
        );
        publishedCol.setPrefWidth(180);

        TableColumn<RailTrafficInformationRecord, String> titleCol = new TableColumn<>("Titel");
        titleCol.setCellValueFactory(data ->
                new ReadOnlyStringWrapper(data.getValue().fields.title)
        );
        titleCol.setPrefWidth(250);

        TableColumn<RailTrafficInformationRecord, String> descriptionCol = new TableColumn<>("Beschreibung");
        descriptionCol.setCellValueFactory(data ->
                new ReadOnlyStringWrapper(data.getValue().fields.description)
        );
        descriptionCol.setPrefWidth(550);

        table.getColumns().addAll(publishedCol, titleCol, descriptionCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);

        return table;
    }
}
