package com.alimuzaffar.test;

public class Main {


    public static void main(String[] args) {
        final int treeHeight = 10;
        final int trunkHeight = treeHeight - ((treeHeight * 4) / 5); // This will round down, round up instead?
        final int leafHeight = treeHeight - trunkHeight;

        final int spaceForNum = String.valueOf(treeHeight).length();
        final String numFormat = "%"+spaceForNum+"d|";
        final int maxStars = (leafHeight * 2) - 1;

        StringBuilder sb = new StringBuilder();
        for (int i = treeHeight; i > 0; i--) {
            sb.append(String.format(numFormat, i));
            int stars = (treeHeight - i) == 0? 1 : (treeHeight - i)*2 + 1;
            int space = (maxStars - stars) != 0? (maxStars - stars)/2 : 0;
            if (space < 0) {
                stars = 3;
                space = (maxStars - stars)/2;
            }
            String starsStr = repeatChar(stars, '*');
            if (space != 0 && space > 0) {
                String spaceStr = repeatChar(space, ' ');
                sb.append(spaceStr);
                sb.append(starsStr);
                sb.append(spaceStr);
            } else if (space == 0){
                sb.append(starsStr);
            }
            sb.append(String.format("|%d=%d+%d+%d%n", maxStars, space, stars, space));
        }
        System.out.println(sb.toString());
    }

    static String repeatChar(int count, char character) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
        return sb.toString();
    }
}
