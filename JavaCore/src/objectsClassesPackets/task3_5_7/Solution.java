package objectsClassesPackets.task3_5_7;

/*
        Пришло время попробовать реализовать иерархию классов определенного вида и решить конкретную задачу.

        Представим, вы делаете систему фильтрации комментариев на каком-то веб-портале, будь то новости, видео-хостинг, а может даже для системы онлайн-обучения :).
        Вы хотите фильтровать комментарии по разным критериям, уметь легко добавлять новые фильтры и модифицировать старые.
        Допустим, мы будем фильтровать спам, комментарии с негативным содержанием и слишком длинные комментарии.

        Спам будем фильтровать по наличию указанных ключевых слов в тексте.Негативное содержание будем определять по наличию одного из трех смайликов -  :( =( :|.
        Слишком длинные комментарии будем определять исходя из данного числа - максимальной длины комментария.
        TextAnalyzer и Label уже подключены, лишние импорты вам не потребуются.
 */

public class Solution {
    public static void main(String[] args) {
        TextAnalyzer[] analyzers = new TextAnalyzer[]{
                new SpamAnalyzer(new String[]{"хуевый", "сасай кудасай"}),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(25)
        };
        System.out.println(checkLabels(analyzers, "Пиздатый текст для теста.")); //Вариант ОК
        System.out.println(checkLabels(analyzers, "Хуевый текст для теста, так как это :( ужас.")); //NEGATIVE_TEXT по смайлику
        System.out.println(checkLabels(analyzers, "Хуевый текст для теста, полный сасай кудасай.")); //SPAM по слову сасай кудасай, Хуевый не катит, потому-что с большой буквы
        System.out.println(checkLabels(analyzers, "И это все, что вы хотели написать в комментариях. Да ну, вообще..."));//TOO_LONG потому-что более 25 символов
    }
/*
    TODO Вам необходимо реализовать три класса, которые реализуют данный интерфейс: SpamAnalyzer, NegativeTextAnalyzer и TooLongTextAnalyzer.
         SpamAnalyzer должен конструироваться от массива строк с ключевыми словами. Объект этого класса должен сохранять в своем состоянии этот массив строк в приватном поле keywords.
         NegativeTextAnalyzer должен конструироваться конструктором по-умолчанию.
         TooLongTextAnalyzer должен конструироваться от int-а с максимальной допустимой длиной комментария.
         Объект этого класса должен сохранять в своем состоянии это число в приватном поле maxLength.
         Cделаем SpamAnalyzer и NegativeTextAnalyzer наследниками KeywordAnalyzer и реализуем абстрактные методы.
 */

    public static class SpamAnalyzer extends KeywordAnalyzer {
        private String[] keywords;

        public SpamAnalyzer(String[] keywords) {
            this.keywords = keywords;
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        public Label getLabel() {
            return Label.SPAM;
        }

    }


    public static class NegativeTextAnalyzer extends KeywordAnalyzer {
        private String[] keysymbols = {":(", "=(", ":|"};

        @Override
        protected String[] getKeywords() {
            return keysymbols;
        }

        @Override
        public Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }

    }


    public static class TooLongTextAnalyzer implements TextAnalyzer {
        private int maxLength;

        public TooLongTextAnalyzer(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public Label processText(String text) {
            return text.length() > maxLength ? Label.TOO_LONG : Label.OK;
        }
    }
/*
    TODO Наверняка вы уже заметили, что SpamAnalyzer и NegativeTextAnalyzer во многом похожи: они оба проверяют текст на наличие каких-либо ключевых слов
         (в случае спама мы получаем их из конструктора, в случае негативного текста мы заранее знаем набор грустных смайликов)
         и в случае нахождения одного из ключевых слов возвращают Label (SPAM и NEGATIVE_TEXT соответственно), а если ничего не нашлось возвращают OK.
         Давайте эту логику абстрагируем в абстрактный класс KeywordAnalyzer следующим образом:
         Выделим два абстрактных метода getKeywords и getLabel, один из которых будет возвращать набор ключевых слов, а второй метку, которой необходимо пометить положительные срабатывания.
         Нам незачем показывать эти методы потребителям классов, поэтому оставим доступ к ним только для наследников.
         Реализуем processText таким образом, чтобы он зависел только от getKeywords и getLabel.
         Сделаем SpamAnalyzer и NegativeTextAnalyzer наследниками KeywordAnalyzer и реализуем абстрактные методы.
 */

    public abstract static class KeywordAnalyzer implements TextAnalyzer {

        abstract protected String[] getKeywords();

        abstract protected Label getLabel();

        @Override
        public Label processText(String text) {
            for (String keyword : getKeywords()) {
                if (text.contains(keyword)) {
                    return getLabel();
                }
            }
            return Label.OK;
        }
    }
/*
    TODO Последний штрих - написать метод checkLabels, который будет возвращать метку для комментария по набору анализаторов текста.
         checkLabels должен возвращать первую не-OK метку в порядке данного набора анализаторов, и OK, если все анализаторы вернули OK.
         Используйте, пожалуйста, самый открытый модификатор доступа для всех классов.
         В итоге, реализуйте классы KeywordAnalyzer, SpamAnalyzer, NegativeTextAnalyzer и TooLongTextAnalyzer и метод checkLabels.
         TextAnalyzer и Label уже подключены, лишние импорты вам не потребуются.
 */

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer check : analyzers) {
            if (check.processText(text) != Label.OK) {
                return check.processText(text);
            }
        }
        return Label.OK;
    }
}



