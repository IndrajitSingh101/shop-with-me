package com.ienliven.messaging;

import com.ienliven.data.Item;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class InventoryEvent {
    private String eventType;
    private Item item;
}
