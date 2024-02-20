import Card from "components/common/Card/Card";

export default function AdvertisementUuid({ id }) {
  return (
    <Card>
      <span className="text-black">UUID ogłoszenia : {id}</span>
    </Card>
  );
}
