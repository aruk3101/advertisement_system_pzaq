export default function SpinnerView(props) {
  const { isLoading = false } = props;
  return (
    <>
      {isLoading === true ? (
        <div className="d-block text-center m-3 m-md-5">
          <div class="spinner-border" role="status">
            <span class="visually-hidden">Loading...</span>
          </div>
        </div>
      ) : (
        props.children
      )}
    </>
  );
}
