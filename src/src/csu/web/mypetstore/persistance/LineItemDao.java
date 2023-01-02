package csu.web.mypetstore.persistance;

import csu.web.mypetstore.domain.LineItem;

import java.util.List;

public interface LineItemDao {
    List<LineItem> getLineItemsByOrderId(int orderId);
    String getLineItemsByOrderIdString = "SELECT ORDERID,LINENUM AS lineNumber,ITEMID,QUANTITY, "
            + "UNITPRICE FROM LINEITEM WHERE ORDERID = ?";

    void insertLineItem(LineItem lineItem);
    String insertLineItemString = "INSERT INTO LINEITEM (ORDERID, LINENUM, ITEMID, QUANTITY, "
            + "UNITPRICE) VALUES (?, ?, ?, ?, ?)";
}
