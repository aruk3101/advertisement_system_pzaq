import { request } from "./AxiosService";

const BASE_URL = "advertisementCategories/";

function combine(url) {
  return BASE_URL + url;
}

export function GetAdvertisementCategories() {
  return request({
    method: "get",
    url: BASE_URL,
  }).then((res) => {
    return res;
  });
}
