package interview.drills.sortObjects;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MainMain {
    public static void main(String[] args) {
        OrderO order1 = new OrderO(1, LocalDate.of(2024, 03, 18), 150.0, "home", LocalDate.of(2024, 03, 30), 500081);
        OrderO order2 = new OrderO(2, LocalDate.of(2024, 03, 12),  90.0, "dome", LocalDate.of(2024, 03, 30), 500081);
        OrderO order3 = new OrderO(3, LocalDate.of(2024, 03, 12), 110.0, "home", LocalDate.of(2024, 03, 30), 500081);
        OrderO order4 = new OrderO(4, LocalDate.of(2024, 03, 15), 150.0, "home", LocalDate.of(2024, 03, 30), 500081);
        OrderO order5 = new OrderO(5, LocalDate.of(2024, 03, 15), 100.0, "dome", LocalDate.of(2024, 03, 30), 500081);

        List<OrderO> orderList = List.of(order1, order2, order3, order4, order5);

        new MainMain().applySorting(orderList, List.of("orderDate", "category","price", "orderId"));
    }

    private void applySorting(List<OrderO> orderList, List<String> paramList) {
        MainMain mainmain = new MainMain();
        Map<String, Comparator<OrderO>> allComparators = mainmain.allComparators();
        Comparator<OrderO> all = paramList.stream()
                .map(allComparators::get)
                .reduce(Comparator::thenComparing)
                .orElse((a,b)->0);

//        for(int i = 0; i < paramList.size(); i++) {
//            System.out.println(allComparators.get(paramList.get(i)));
//        }

        orderList.stream()
                .sorted(all)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    public Map<String, Comparator<OrderO>> allComparators() {
        Map<String, Comparator<OrderO>> allComparators = new HashMap<>();
        Comparator<OrderO> categoryComparator = Comparator.comparing(OrderO::getCategory);
        Comparator<OrderO> orderIdComparator = Comparator.comparing(OrderO::getOrderId);
        Comparator<OrderO> priceComparator = Comparator.comparing(OrderO::getPrice);
        Comparator<OrderO> orderDateComparator = Comparator.comparing(OrderO::getOrderDate);
        allComparators.put("orderDate", orderDateComparator);
        allComparators.put("category", categoryComparator);
        allComparators.put("orderId", orderIdComparator);
        allComparators.put("price", priceComparator);




        return allComparators;
    }
}
