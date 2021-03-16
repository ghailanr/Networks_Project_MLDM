package Datas;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {
    private ArrayList<Page> listPages = new ArrayList<>();
    private String desc;

    public Book(){
    }

    public Page getPage(int index){
        return this.listPages.get(index);
    }
}
