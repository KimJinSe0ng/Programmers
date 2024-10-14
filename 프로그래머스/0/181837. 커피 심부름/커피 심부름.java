class Solution {
    public int solution(String[] order) {
        int totalCost = 0;

        int americanoPrice = 4500;
        int cafelattePrice = 5000;

        for (String menu : order) {
            if (menu.contains("americano") || menu.equals("anything")) {
                totalCost += americanoPrice;
            } else if (menu.contains("cafelatte")) {
                totalCost += cafelattePrice;
            }
        }

        return totalCost;
    }
}