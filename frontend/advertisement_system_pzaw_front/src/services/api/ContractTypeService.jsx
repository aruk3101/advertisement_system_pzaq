import { request } from "./AxiosService";

const BASE_URL = "contractTypes/";

function combine(url) {
  return BASE_URL + url;
}

export function GetContractTypes() {
  return request({
    method: "get",
    url: BASE_URL,
  }).then((res) => {
    return res;
  });
}
