//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.03.26 at 07:59:43 PM CET 
//


package travelcompany;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="population" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isCapital" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="climate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numOfSights" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numOfBeaches" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numOfSkiResorts" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "population",
    "isCapital",
    "climate",
    "numOfSights",
    "numOfBeaches",
    "numOfSkiResorts"
})
@XmlRootElement(name = "city")
public class City {

    @XmlElement(required = true)
    protected String name;
    protected int population;
    protected boolean isCapital;
    @XmlElement(required = true)
    protected String climate;
    protected int numOfSights;
    protected int numOfBeaches;
    protected int numOfSkiResorts;
    @XmlAttribute(name = "type", required = true)
    protected String type;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the population property.
     * 
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Sets the value of the population property.
     * 
     */
    public void setPopulation(int value) {
        this.population = value;
    }

    /**
     * Gets the value of the isCapital property.
     * 
     */
    public boolean isIsCapital() {
        return isCapital;
    }

    /**
     * Sets the value of the isCapital property.
     * 
     */
    public void setIsCapital(boolean value) {
        this.isCapital = value;
    }

    /**
     * Gets the value of the climate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClimate() {
        return climate;
    }

    /**
     * Sets the value of the climate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClimate(String value) {
        this.climate = value;
    }

    /**
     * Gets the value of the numOfSights property.
     * 
     */
    public int getNumOfSights() {
        return numOfSights;
    }

    /**
     * Sets the value of the numOfSights property.
     * 
     */
    public void setNumOfSights(int value) {
        this.numOfSights = value;
    }

    /**
     * Gets the value of the numOfBeaches property.
     * 
     */
    public int getNumOfBeaches() {
        return numOfBeaches;
    }

    /**
     * Sets the value of the numOfBeaches property.
     * 
     */
    public void setNumOfBeaches(int value) {
        this.numOfBeaches = value;
    }

    /**
     * Gets the value of the numOfSkiResorts property.
     * 
     */
    public int getNumOfSkiResorts() {
        return numOfSkiResorts;
    }

    /**
     * Sets the value of the numOfSkiResorts property.
     * 
     */
    public void setNumOfSkiResorts(int value) {
        this.numOfSkiResorts = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
