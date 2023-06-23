/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


/**
 *
 * @author NUWAA
 */
interface RealAnimal {
    public abstract void eat(String eat);
    public abstract void makeSound(String sound);
}

class Lion implements RealAnimal {

    @Override
    public void eat(String eat) {}

    @Override
    public void makeSound(String sound) {
        gui.Lab.toySoundtField.setText(sound);

    }
}

interface ToyAnimal {
    public abstract void squeak(String sound);
}

class ToyLion implements ToyAnimal {
    @Override
    public void squeak(String sound) {}
}

class AnimalAdapter implements ToyAnimal {

    RealAnimal realAnimal;

    public AnimalAdapter(RealAnimal realAnimal) {
        this.realAnimal = realAnimal;
    }

    @Override
    public void squeak(String sound) {
        realAnimal.makeSound(sound);
    }
}

public class Context {

    Lion l = new Lion();
    ToyAnimal tl = new ToyLion();

    ToyAnimal animalAdapter = new AnimalAdapter(l);

    void process(String eat, String sound) {
        animalAdapter.squeak(sound);
    }
}
