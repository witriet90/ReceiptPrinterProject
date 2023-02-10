package input;

public class ConsoleInputParser {
    public PurchaseInput parse(String[] consoleInput) {
        if (consoleInput.length == 0) {
            throw new InputParserException("Cannot is build check with empty input");
        }
        InputParser parser = new InputParser();
        String filePath = getFilePath(consoleInput[0]);
        if (filePath == null) {
            return parser.parse(consoleInput);
        } else {
            InputFileReader reader = new InputFileReader();
            return parser.parse(reader.read(filePath));
        }
    }

    private String getFilePath(String consoleInput) {
        String[] inputParts = consoleInput.split("-");
        if (inputParts[0].equals("file")) {
            if (inputParts.length == 1) {
                throw new InputParserException("File is not provided");
            }
            return inputParts[1];
        }
        return null;
    }
}
