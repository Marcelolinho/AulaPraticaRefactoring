package src;

public class HtmlStatement extends Statement {
    public String value(Customer aCustomer) {
        StringBuilder result = new StringBuilder();

        appendHeader(result, aCustomer);

        appendRentalDetails(result, aCustomer);

        appendFooter(result, aCustomer);

        return result.toString();
    }

    private void appendHeader(StringBuilder result, Customer aCustomer) {
        result.append("<H1>Rentals for <EM>")
                .append(aCustomer.getName())
                .append("</EM></H1><P>\n");
    }

    private void appendRentalDetails(StringBuilder result, Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result.append(each.getMovie().getTitle())
                    .append(": ")
                    .append(each.getCharge())
                    .append("<BR>\n");
        }
    }

    private void appendFooter(StringBuilder result, Customer aCustomer) {
        result.append("<P>You owe <EM>")
                .append(aCustomer.getTotalCharge())
                .append("</EM><P>\n")
                .append("On this rental you earned <EM>")
                .append(aCustomer.getTotalFrequentRenterPoints())
                .append("</EM> frequent renter points<P>");
    }
}