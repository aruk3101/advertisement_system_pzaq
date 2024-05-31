import { request } from "./AxiosService";

const BASE_URL = "companies/";

function combine(url) {
  return BASE_URL + url;
}

function handleErrors(response) {
  switch (response.status) {
    //kolejne przypadki
    default:
      return {
        ...response,
        message:
          "Wystąpił nieokreślony błąd, skontaktuj się z administratorem, lub spróbuj ponownie",
      };
  }
}

export function EditCompany(data, uuid) {
  console.log(data);
  console.log(data.addressVersion);
  return request({
    method: "put",
    url: combine(uuid),
    data: {
      name: data.name,
      iframeHyperlink: data.iframeHyperlink,
      updateAddressDto: {
        city: data.city,
        postalName: data.postalName,
        postalCode: data.postalCode,
        street: data.street,
        streetNumber: data.streetNumber,
        apartmentNumber: data.apartmentNumber,
        country: data.country,
        version: data.addressVersion,
      },
      description: data.description,
      version: data.version,
    },
  }).then((res) => {
    if (!res.isSuccesfull) {
      return handleErrors(res);
    }
    return res;
  });
}

export function AddCompany(data) {
  return request({
    method: "post",
    url: BASE_URL,
    data: data,
  }).then((res) => {
    if (!res.isSuccesfull) {
      return handleErrors(res);
    }
    return res;
  });
}

export function GetCompanies(page, size) {
  return request({
    method: "get",
    url: BASE_URL + "?page=" + page + "&size=" + size,
  }).then((res) => {
    if (!res.isSuccesfull) {
      return handleErrors(res);
    }
    return res;
  });
}

export function GetCompany(uuid) {
  return request({
    method: "get",
    url: combine(uuid),
  }).then((res) => {
    if (!res.isSuccesfull) {
      return handleErrors(res);
    }
    return res;
  });
}

// export function DeleteUserCourse(uuid) {
//   return request({
//     method: "delete",
//     url: combine(uuid),
//   }).then((res) => {
//     if (!res.isSuccesfull) {
//       return handleErrors(res);
//     }
//     return res;
//   });
// }
