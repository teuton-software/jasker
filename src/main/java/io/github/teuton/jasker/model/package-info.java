@XmlSchema(
		namespace = "http://io.github.teuton-software/asker",
		xmlns = {
				@XmlNs(prefix = "", namespaceURI = "http://io.github.teuton-software/asker"), 
				@XmlNs(prefix = "xsi", namespaceURI = "http://www.w3.org/2001/XMLSchema-instance"), 
		},
		elementFormDefault = XmlNsForm.QUALIFIED,
		attributeFormDefault = XmlNsForm.UNQUALIFIED,
		location = "http://io.github.teuton-software/asker https://github.com/teuton-software/asker/releases/download/v2.7.0/asker.xsd"
)
package io.github.teuton.jasker.model;

import jakarta.xml.bind.annotation.XmlSchema;
import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
