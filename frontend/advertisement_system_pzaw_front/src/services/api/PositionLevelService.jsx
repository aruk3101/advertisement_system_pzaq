import { request } from "./AxiosService";

const BASE_URL = "positionLevels/";

function combine(url) {
  return BASE_URL + url;
}

export function GetPositionLevels() {
  return request({
    method: "get",
    url: BASE_URL,
  }).then((res) => {
    return res;
  });
}
