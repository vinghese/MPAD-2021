package cusat.ddukk.mpad_2021_first.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListModel {

    public static HashMap<String, List<String>> getData() {

        HashMap<String,List<String>> expandableList = new HashMap<>();

        List<String> cricket = new ArrayList<>();
        cricket.add("India");
        cricket.add("Australia");
        cricket.add("Pakistan");
        cricket.add("England");
        cricket.add("South Africa");

        List<String> football = new ArrayList<>();
        football.add("Argentina");
        football.add("Portugal");
        football.add("Brazil");
        football.add("Spain");
        football.add("Italy");

        expandableList.put("CRICKET",cricket);
        expandableList.put("FOOTBALL", football);

        return expandableList;

    }


}
