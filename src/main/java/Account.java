public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    /**
     *
     * @return соблюдены ли требования для имени
     */
    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        if (name != null) {
        return name.length() >= 3
                && name.length() <= 19
                && containOneSpace(name)
                && !containSpainInTheBegin(name)
                && !containSpainInTheEnd(name);
        }
        else{
            return false;
        }
    }

    /**
     *
     * @return содержит ли имя только один пробел
     */
    public static boolean containOneSpace(String name){
        int count = 0;
        if(name != null){
            for(int i = 0; i < name.length(); i++){
                if(Character.isWhitespace(name.charAt(i))){
                    count++;
                }
            }
        }
        return count == 1;
    }

    /**
     *
     * @return содержит ли имя пробел в начале
     */
    public static boolean containSpainInTheBegin(String name){
        return (Character.isWhitespace(name.charAt(0)));
    }

    /**
     *
     * @return содержит ли имя пробел в конце
     */
    public static boolean containSpainInTheEnd(String name){
        return (Character.isWhitespace(name.charAt(name.length()-1)));
    }
}