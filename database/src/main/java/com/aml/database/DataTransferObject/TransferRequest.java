package com.aml.database.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequest {
    private int mediaId;
    private int fromBranchId;
    private int toBranchId;
}
