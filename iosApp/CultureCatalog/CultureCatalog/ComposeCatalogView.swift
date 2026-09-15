//
//  ComposeCatalogView.swift
//  CultureCatalog
//
//  Created by Giacomo Pumapillo on 22/08/2026.
//

import SwiftUI
import UIKit
import CultureCatalogKit

struct ComposeCatalogView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        CatalogViewControllerKt.CatalogViewController()
    }

    func updateUIViewController(
        _ uiViewController: UIViewController,
        context: Context
    ) {
    }
}
