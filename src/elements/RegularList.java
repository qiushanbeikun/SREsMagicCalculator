package elements;


import model.Lists;

import java.util.ArrayList;
import java.util.List;

public class RegularList implements Lists{


    List<Double> aNumberList;
    public RegularList (){
        aNumberList = new ArrayList<>();
    }


    @Override
    public void addElement(double number) {
        aNumberList.add(number);
    }

    @Override
    public void changes(int integer, double newValue) {
        aNumberList.set(integer, newValue);
    }

    @Override
    public void removeElement(int position) {
        aNumberList.remove(position);
    }
}
