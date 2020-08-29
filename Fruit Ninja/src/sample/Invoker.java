package sample;

public class Invoker {
    ICommand command;
    public Invoker(ICommand newCommand){
        command = newCommand;
    }
    public void press(){
        command.execute();
    }
    public void undo(){
        command.unexecute();
    }
}