
import java.util.LinkedList;
import java.util.ListIterator;

public class HW4 {

    public static void main(String[] args) {
        LinkedList<Integer> nums = new LinkedList<>();
        HW4 hw4 = new HW4();

        hw4.fillList(nums);

        //Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
        System.out.println(hw4.reverseList(nums));

        //Реализуйте очередь с помощью LinkedList со следующими методами:
        // enqueue() - помещает элемент в конец очереди,
        // dequeue() - возвращает первый элемент из очереди и удаляет его,
        // first() - возвращает первый элемент из очереди, не удаляя.
        hw4.enqueue(nums,777);
        System.out.println(hw4.dequeue(nums));
        System.out.println(hw4.first(nums));

        //Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор
        System.out.println(hw4.sum(nums));
    }

    public void fillList(LinkedList<Integer> nums){
        int amount = (int) (Math.random() * 20);

        for (int i = 0; i < amount; i++) {
            nums.add((int) (Math.random() * 1000));
        }
    }

    public LinkedList<Integer> reverseList(LinkedList<Integer> nums){

        LinkedList <Integer> list = new LinkedList<>();

        for(Integer num:nums){
            list.addFirst(num);
        }

        return list;
    }

    public void enqueue(LinkedList<Integer> nums, Integer numToAdd){
        nums.addLast(numToAdd);
    }

    public Integer dequeue(LinkedList<Integer> nums){
        Integer temp = nums.getFirst();
        nums.removeFirst();
        return temp;
    }

    public Integer first(LinkedList<Integer> nums){
        return nums.getFirst();
    }

    public Integer sum(LinkedList<Integer> nums){
        ListIterator<Integer> iterator = nums.listIterator();
        Integer sum = 0;

        while(iterator.hasNext()){
            Integer integer = iterator.next();
            sum+=integer;
        }

        return sum;
    }
}
