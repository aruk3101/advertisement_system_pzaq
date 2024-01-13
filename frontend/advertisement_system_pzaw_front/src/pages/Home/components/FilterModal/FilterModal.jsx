import "./FilterModal.css";

export default function FilterModal({modalId}){
    return (
        <div className="modal fade" tabindex="-1" id={modalId} aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div className="modal-dialog modal-dialog-scrollable">
            <div className="modal-content">
                <div className="modal-header">
                <h5 className="modal-title">Filtruj wyniki wyszukiwania !</h5>
                <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div className="modal-body">
                <form>
                    i tutaj formularz do filtrowania wyszukiwań na wszystkie możliwe sposoby
                </form>
                </div>
                <div className="modal-footer">
                <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" className="btn btn-primary">Ten przycisk będzie wysyłać formularz</button>
                </div>
            </div>
            </div>
        </div>
    )
}