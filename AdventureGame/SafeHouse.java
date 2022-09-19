package AdventureGame;

public class SafeHouse extends NormalLocation{

    public SafeHouse(Player player) {
        super(player, "Guvenli ev");

    }
    @Override
    public boolean onLocation() {
        System.out.println("Guvenli evdesiniz");
        System.out.println("Caniniz yenilendi:");
        System.out.println("Eski can : "+this.getPlayer().getHealth());
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());
        System.out.println("Yeni can : "+this.getPlayer().getHealth());

        return true;
    }
}
