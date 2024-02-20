import Card from "components/common/Card/Card";
import SimiliarOffers from "components/SimiliarOffers/SimiliarOffers";

export default function SimiliarOffersCard() {
  return (
    <Card
      header="Podobne Oferty"
      bootstrapFontsize="fs-3"
      headerCenter="text-center"
      customMargin="mb-4"
    >
      <SimiliarOffers count={3} />
    </Card>
  );
}
