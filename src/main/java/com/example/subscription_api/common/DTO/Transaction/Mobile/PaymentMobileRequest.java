package com.example.subscription_api.common.DTO.Transaction.Mobile;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PaymentMobileRequest {
    @Schema(description = "Montant de la transaction", required = true)
    private BigDecimal transaction_amount;

    @Schema(description = "Devise de la transaction", hidden = true)
    private String transaction_currency = "XAF";

    @Schema(description = "Méthode de transaction", hidden = true)
    private String transaction_method = "MOBILE";

    @Schema(description = "Référence unique de transaction", hidden = true)
    private UUID transaction_reference;

    @Schema(description = "Identifiant unique du payeur", required = true)
    private String payer_reference;

    @Schema(description = "Nom du payeur", required = true)
    private String payer_name;

    @Schema(description = "Numéro de téléphone du payeur", required = true)
    private String payer_phone_number;

    @Schema(description = "Langue du payeur", required = true)
    private String payer_lang;

    @Schema(description = "Email du payeur", required = true)
    private String payer_email;

    @Schema(description = "Référence du service", hidden = true)
    private String service_reference ;

    @Schema(description = "Nom du service", required = true)
    private String service_name;

    @Schema(description = "Description du service", required= true)
    private String service_description;

    @Schema(description = "Quantité de service", hidden = true)
    private int service_quantity = 1;
}

