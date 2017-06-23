package com.experian.nextgen.ind.model.commercial.uofpojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="STARTRPT")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="STARTRPT")
@XStreamAlias("STARTRPT")
public class ResponseInfoList
  extends ResponseInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
}


/* Location:              C:\\users\c17485a\workspace\neon\webClient\lib\nextgen-ind-pds-deployment-0.50.5-SNAPSHOT.jar!\com\experian\nextgen\ind\model\commercial\\uofpojo\ResponseInfoList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */