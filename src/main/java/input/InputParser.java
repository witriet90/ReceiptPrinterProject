package input;

public class InputParser {

    private PurchaseInputBuilder inputBuilder;

    public PurchaseInput parse(String[] consoleInput) {
        inputBuilder = new PurchaseInputBuilder();

        for (String input : consoleInput) {
            parse(input);
        }

        return inputBuilder.build();
    }

    private void parse(String input) {
        try {
            String[] inputParts = splitInput(input);

            String firstPart = inputParts[0];
            String secondPart = inputParts[1];

            if (!firstPart.equalsIgnoreCase("card")) {
                inputBuilder.addProduct(getInt(firstPart), getInt(secondPart));
            } else {
                inputBuilder.addDiscount(getInt(secondPart));
            }
        } catch (InputParserException e) {
            System.out.println("Invalid input '"+ input+ "'");
        }
    }

    private String[] splitInput(String input) {
        String[] splittedInput = input.split("-");
        if (splittedInput.length == 2) {
            return splittedInput;
        } else {
            throw new InputParserException("Illegal input");
        }
    }

    private int getInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new InputParserException("Invalid input, must be int", e);
        }
    }
}
