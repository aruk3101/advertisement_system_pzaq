import SimiliarOffer from "components/SimiliarOffer/SimiliarOffer";

export default function SimiliarOffers({ count }) {
  //tutaj fetch z api
  let similarOffers = [
    {
      position: "Position",
      company: {
        name: "Company name",
      },
      category: "Category",
      salaryFrom: 4000,
      salaryTo: 8000,
    },
    {
      position: "Position",
      company: {
        name: "Company name",
      },
      category: "Category",
      salaryFrom: 4000,
      salaryTo: 8000,
    },
    {
      position: "Position",
      company: {
        name: "Company name",
      },
      category: "Category",
      salaryFrom: 4000,
      salaryTo: 8000,
    },
  ];
  return (
    <>
      {similarOffers.map((value) => (
        <SimiliarOffer offer={value} />
      ))}
    </>
  );
}
