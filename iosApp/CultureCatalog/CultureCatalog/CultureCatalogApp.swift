//
//  CultureCatalogApp.swift
//  CultureCatalog
//
//  Created by Giacomo Pumapillo on 22/08/2026.
//

import SwiftUI

@main
struct CultureCatalogApp: App {
    var body: some Scene {
        WindowGroup {
            ComposeCatalogView()
                .ignoresSafeArea()
        }
    }
}
