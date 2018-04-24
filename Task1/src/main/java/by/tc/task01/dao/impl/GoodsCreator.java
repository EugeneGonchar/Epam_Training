package by.tc.task01.dao.impl;

import by.tc.task01.entity.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoodsCreator {
    private static GoodsCreator instance;
    private Map<String, Goods> typeInstances = new HashMap<>();

    private GoodsCreator() {
        initTypeInstances();
    }

    public static GoodsCreator getInstance() {

        if (instance == null) {
            instance = new GoodsCreator();
        }
        return instance;
    }

    private void initTypeInstances(){
        typeInstances.put("Oven", new Oven());
        typeInstances.put("Laptop", new Laptop());
        typeInstances.put("Refrigerator", new Refrigerator());
        typeInstances.put("TabletPC", new TabletPC());
        typeInstances.put("VacuumCleaner", new VacuumCleaner());
        typeInstances.put("Speakers", new Speakers());
        typeInstances.put("TextBook", new TextBook());
        typeInstances.put("Newspaper", new Newspaper());
    }


    public Goods createGoodsAndParameterize(String type, Map<String, String> parameters) { //throws ItemCreationFailedException {
        Goods goods = typeInstances.get(type);
        parameterize(goods, parameters);

        return goods;
    }


    private void parameterize(Goods goods, Map<String, String> parameters) { //throws ItemCreationFailedException {
        parameters = makeKeysLookLikeFields(parameters);

        try {
            for (String key : parameters.keySet()) {
                Field field = goods.getClass().getDeclaredField(key);
                field.setAccessible(true);

                if (field.getType().getName().equals("double")) {
                    field.set(goods, Double.valueOf(parameters.get(key)));
                } else {
                    field.set(goods, parameters.get(key));
                }
            }
        } catch (Exception e) {
            //throw new ItemCreationFailedException(goods.getClass().getName() + " creation failed");
        }
    }

    private Map<String, String> makeKeysLookLikeFields(Map<String, String> parameters) {
        Map<String, String> convertedParameters = new HashMap<>();

        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            convertedParameters.put(formatKey(entry.getKey()), entry.getValue());
        }
        return convertedParameters;
    }


    // converts a string like power_consumption
    // into a string powerConsumption
    // in order to match the fields of the class

    private String formatKey(String key) {
        key = key.toLowerCase();
        Pattern p = Pattern.compile("_([a-zA-Z])");
        Matcher m = p.matcher(key);
        StringBuffer sb = new StringBuffer();

        while (m.find()) {
            m.appendReplacement(sb, m.group(1).toUpperCase());
        }
        m.appendTail(sb);

        return new String(sb);
    }
}
