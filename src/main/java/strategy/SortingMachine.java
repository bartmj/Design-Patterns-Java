package strategy;

public class SortingMachine {

    Sorter sorter;

    public SortingMachine(Sorter sorter) {
        this.sorter = sorter;
    }

    public void executeSorting(int[] arr) {
        sorter.sort(arr);
    }

}
