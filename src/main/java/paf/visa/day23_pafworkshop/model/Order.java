package paf.visa.day23_pafworkshop.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable{
    private Integer orderId;
    private Date orderDate;
    private Integer custId;
    private Integer prodId;
    private float total;
    private float cost;
}
