package hw2;

public class TrollFactory implements PandoraBox {
    @Override
    public CanAppear open() {
        return new Troll();
    }
}
