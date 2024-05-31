import { request } from "./AxiosService";

const BASE_URL = "workingTimeTypes/";

function combine(url) {
  return BASE_URL + url;
}

export function GetWorkingTimeTypes() {
  return request({
    method: "get",
    url: BASE_URL,
  }).then((res) => {
    return res;
  });
}
