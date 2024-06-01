import { request } from "./AxiosService";

const BASE_URL = "languageLevels/";

function combine(url) {
  return BASE_URL + url;
}

export function GetLanguageLevels() {
  return request({
    method: "get",
    url: BASE_URL,
  }).then((res) => {
    return res;
  });
}
