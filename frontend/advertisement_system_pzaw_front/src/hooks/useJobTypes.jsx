import { useState, useEffect } from "react";
import { GetJobTypes } from "services/api/JobTypeService";

const useJobTypes = () => {
  const [jobTypes, setJobTypes] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchItems();
  }, []);

  const fetchItems = () => {
    setLoading(true);
    GetJobTypes().then((res) => {
      handle(res);
    });
  };

  const handle = (res) => {
    if (res.isSuccesfull) {
      setJobTypes(res.data);
      setLoading(false);
      return;
    }
  };

  return {
    jobTypes,
    loading,
    fetchItems,
  };
};

export default useJobTypes;
