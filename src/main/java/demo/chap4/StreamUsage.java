package demo.chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {

    public static void main(String[] args) {

        // filter 筛选
        List<Dish> dishes = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println(dishes);

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        List<Integer> filterNumbers = numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(filterNumbers);


        // limit 切片
        List<Dish> limitDishes = Dish.menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(limitDishes);


        // skip 跳过
        List<Dish> skipDishes = Dish.menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(skipDishes);

        // map 映射
        List<Integer> mapDishes = Dish.menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(mapDishes);

        // flatmap 流的扁平化
        String[] arrayOfWords = {"Goodbye","World"};
        List<String> uniqueCharacters = Arrays.stream(arrayOfWords)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueCharacters);

        Integer[] arrayOfInts = {1,2,3,4,5};
        List<Integer> squares = Arrays.stream(arrayOfInts)
                .map(i -> i * i)
                .collect(Collectors.toList());
        System.out.println(squares);



    }



}
