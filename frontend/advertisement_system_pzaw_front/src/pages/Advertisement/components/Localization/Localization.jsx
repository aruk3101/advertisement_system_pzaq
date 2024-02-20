import Card from "components/common/Card/Card";

export default function Localization({ iframeLink }) {
  return (
    <Card customPadding="m-0" id="lokalizacja">
      <iframe src={iframeLink} className="w-100 h-100" />
    </Card>
  );
}
