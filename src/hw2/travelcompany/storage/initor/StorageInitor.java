package hw2.travelcompany.storage.initor;

import hw2.travelcompany.country.domain.Country;
import hw2.travelcompany.country.service.CountryService;
import hw2.travelcompany.storage.initor.datasourcereader.CountriesWithCitiesXmlSaxParser;
import hw2.travelcompany.storage.initor.datasourcereader.CountriesWithCitiesXmlStaxParser;
import hw2.travelcompany.storage.initor.datasourcereader.DataSourceIoTxtFileFromResourcesReader;
import hw2.travelcompany.storage.initor.datasourcereader.DataSourceReader;
import hw2.travelcompany.storage.initor.datasourcereader.FileParser;

import java.util.ArrayList;
import java.util.List;

public class StorageInitor {
    private CountryService countryService;

    public StorageInitor(CountryService countryService) {
        this.countryService = countryService;
    }

    public enum DataSourceType {
        TXT_FILE, XML_FILE, JSON_FILE;
    }

    public void initStorageWithCountriesAndCities(String filePath, DataSourceType dataSourceType) throws Exception {
        List<Country> countriesToPersist = getCountriesFromStorage(filePath, dataSourceType);
        
        if (!countriesToPersist.isEmpty()) {
            for (Country country : countriesToPersist) {
                countryService.insert(country);
            }
        }
    }

    private List<Country> getCountriesFromStorage(String filePath, DataSourceType dataSourceType) throws Exception {

        List<Country> countries = new ArrayList<>();
        FileParser<List<Country>> dataSourceReader = null;

        switch (dataSourceType) {
            case TXT_FILE: {
                dataSourceReader = new DataSourceIoTxtFileFromResourcesReader();
                break;
            }
            case XML_FILE: {
                dataSourceReader = new CountriesWithCitiesXmlSaxParser();
                break;
            }
            case JSON_FILE: {
                break;
            }
        }
        if (dataSourceReader != null) {
            countries = dataSourceReader.parseFile(filePath);
        }
        return countries;
    }
}
