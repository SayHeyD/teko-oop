package Racing;

import java.util.concurrent.TimeUnit;

public class RennHandler
{
    Rennstruktur rennen;
    
    public void setRennen(Rennstruktur rennen){
        this.rennen = rennen;
    }
    
    public void start(){
        boolean finished = false;
        while(!finished){
            finished = rennen.durchfuehren();
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
