import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.cli.*;

import java.util.Arrays;
import java.util.Optional;

public class Main {

    public static void main(String args[]) throws Exception {

        Option flag = Option.builder("i")
                .longOpt("flag")
                .desc("Binary input: 1 or 0")
                .hasArg(true)
                .build();

        Option fileName = Option.builder("f")
                .longOpt("file name")
                .desc("Path to file for read/write")
                .hasArg(true)
                .build();

        final Options options = new Options();
        options.addOption(flag);
        options.addOption(fileName);

        final CommandLineParser parser = new DefaultParser();
        final HelpFormatter formatter = new HelpFormatter();
        final ObjectMapper mapper = new ObjectMapper();

        Optional<Integer> binaryFlag = Optional.empty();
        Optional<String> filePath = Optional.empty();

        try {
            final CommandLine command = parser.parse(options, args);
            binaryFlag = Optional.of(Integer.parseInt(command.getOptionValue("flag")));
            filePath = Optional.of(command.getOptionValue("file name"));
        } catch (ParseException e) {
            System.out.println(String.format("Couldn't parse input: %s", e.getMessage()));
            formatter.printHelp("utility-name", options);
            System.exit(1);
        }

        if (binaryFlag.get() == 0) {
            final JsonModel jsonModel = JsonModel.newBuilder()
                    .setBackwardsInPython(Arrays.asList(0, 1, 2, 3, 4, 5,6, 7, 8, 9))
                    .setDescription("Made in Java")
                    .setMadeWithPython(false)
                    .build();

            filePath.ifPresentOrElse(file -> Serializer.writeJsonToFile(mapper, jsonModel, file),
                    () -> System.out.println("The file path doesn't exist or wasn't specified"));
        } else if (binaryFlag.get() == 1) {
            filePath.ifPresentOrElse(file -> Deserializer.readJsonFileToObject(mapper, JsonModel.class, file),
                    () -> System.out.println("The file path doesn't exist or wasn't specified"));
        } else {
            System.out.println("Unfortunately, the binary flag is binary ... try again");
            System.exit(1);
        }
    }
}
