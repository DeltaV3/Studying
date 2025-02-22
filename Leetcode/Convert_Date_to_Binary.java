public class Convert_Date_to_Binary {

    public String convertDateToBinary(String date) {
        String binary = "";
        for (int i = 0; i < 3; i++) {
            if(i < 2){
                binary = binary.concat(Integer.toBinaryString(Integer.parseInt(date.split("-")[i])).concat("-"));
            } else {
                binary = binary.concat(Integer.toBinaryString(Integer.parseInt(date.split("-")[i])));
            }
        }
        return binary;
    }

    public static void main(String[] args) {
        Convert_Date_to_Binary convert = new Convert_Date_to_Binary();
        System.out.println(convert.convertDateToBinary("1900-01-01"));
    }
}
