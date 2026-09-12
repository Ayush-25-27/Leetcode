class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;                     // shift to 0-indexed for this digit
            int rem = columnNumber % 26;
            char c = (char) ('A' + rem);
            sb.append(c);
            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }
}