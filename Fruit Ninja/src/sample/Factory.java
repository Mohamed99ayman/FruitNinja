package sample;

public class Factory {

    public Fruit makeFruit(int index){
        if(index == 0)
            return new WaterMelon();
        else if (index == 1)
            return new Mango();
        else if (index == 2)
            return new Orange();
        else if (index == 3)
            return new Pineapple();
        else if (index == 4)
            return new Apple();
        else
            return null;
    }

    public Bomb makeBomb(int index){
        if(index == 0)
            return new DangerousBomb();
        else if (index == 1)
            return new FatalBomb();
        else
            return null;
    }
    public SpecialFruit makeSpecialFruit(int index){

        if (index == 0)
            return new DragonFruit();
        else if (index == 1)
            return new Pomegranate();
        else
            return null;
    }
}