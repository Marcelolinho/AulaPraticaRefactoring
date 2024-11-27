package src;

public class TextStatement extends Statement {
    public String value(Customer aCustomer) {
        StringBuilder result = new StringBuilder();

        appendHeader(result, aCustomer);

        appendRentalDetails(result, aCustomer);

        appendFooter(result, aCustomer);

        return result.toString();
    }

    private void appendHeader(StringBuilder result, Customer aCustomer) {
        result.append("Rental Record for ")
                .append(aCustomer.getName())
                .append("\n");
    }

    private void appendRentalDetails(StringBuilder result, Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result.append("\t")
                    .append(each.getMovie().getTitle())
                    .append("\t")
                    .append(each.getCharge())
                    .append("\n");
        }
    }

    private void appendFooter(StringBuilder result, Customer aCustomer) {
        result.append("Amount owed is ")
                .append(aCustomer.getTotalCharge())
                .append("\n")
                .append("You earned ")
                .append(aCustomer.getTotalFrequentRenterPoints())
                .append(" frequent renter points");
    }
}