package by.epam.buhai.xml_analyzer.main;

import by.epam.buhai.xml_analyzer.service.AnalyzerService;
import by.epam.buhai.xml_analyzer.service.ServiceFactory;
import by.epam.buhai.xml_analyzer.service.service_exception.ServiceException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ServiceFactory factory = ServiceFactory.getInstance();

        try (AnalyzerService reader = factory.getAnalyzerService()) {
            reader.setPath("damagednotes.xml");
            while (reader.hasNext()) {
                PrintInfo.print(reader.findNode());
            }

            //////////////////////////////////////////////////////////////

            reader.setPath("breakfastMenu.xml");
            while (reader.hasNext()) {
                PrintInfo.printWithColumns(reader.findNode());
            }

        } catch (ServiceException e) {
            LOGGER.log(Level.INFO, e.getCause());
        }
    }
}
