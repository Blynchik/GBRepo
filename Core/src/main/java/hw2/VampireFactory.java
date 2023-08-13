package hw2;

public class VampireFactory implements PandoraBox{
    @Override
    public CanAppear open() {
        return new Vampire();
    }
}
