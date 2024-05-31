import { useState, useEffect } from "react";
import { GetContractTypes } from "services/api/ContractTypeService";

const useContractTypes = () => {
  const [contractTypes, setContractTypes] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchItems();
  }, []);

  const fetchItems = () => {
    setLoading(true);
    GetContractTypes().then((res) => {
      handle(res);
    });
  };

  const handle = (res) => {
    if (res.isSuccesfull) {
      setContractTypes(res.data);
      setLoading(false);
      return;
    }
  };

  return {
    contractTypes,
    loading,
    fetchItems,
  };
};

export default useContractTypes;
