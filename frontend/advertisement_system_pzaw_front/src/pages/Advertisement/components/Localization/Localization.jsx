import Card from "components/common/Card/Card";

export default function Localization({ iframeLink, company = null }) {
  console.log(company);
  console.log(iframeLink);
  return (
    <Card customPadding="m-0" id="lokalizacja">
      <iframe
        src={company != null ? company.iframeHyperlink : iframeLink}
        className="w-100 h-100"
      />
    </Card>
  );
}
